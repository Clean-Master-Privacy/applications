import os
import subprocess
import sys
import time
import sqlite3
import psutil
import platform
import tkinter as tk
from tkinter import scrolledtext, messagebox
import threading

def install(package):
    """Installs the required library."""
    subprocess.check_call([sys.executable, "-m", "pip", "install", package])

def check_and_install_libraries():
    """Checks if the required libraries are installed and installs any that are missing."""
    required_packages = ["psutil"]
    for package in required_packages:
        try:
            __import__(package)
        except ImportError:
            print(f"Installing {package} library...")
            install(package)

class SystemMaintenance:
    DATABASE_NAME = "maintenance_results.db"
    CRITICAL_TEMPERATURE = 75  # Temperature warning threshold (Celsius)

    def __init__(self):
        self.setup_environment()

    def setup_environment(self):
        """Sets up the necessary database."""
        self.connect_to_database()

    def connect_to_database(self):
        """Creates a database connection and sets up the required table."""
        try:
            self.conn = sqlite3.connect(self.DATABASE_NAME)
            self.cursor = self.conn.cursor()
            self.cursor.execute('''
                CREATE TABLE IF NOT EXISTS maintenance_log (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    operation TEXT,
                    description TEXT,
                    timestamp TEXT
                );
            ''')
            self.conn.commit()
        except Exception as e:
            print(f"Error: {e}")

    def log_operation(self, operation, description):
        """Logs an operation in the maintenance log."""
        self.cursor.execute('''
            INSERT INTO maintenance_log (operation, description, timestamp)
            VALUES (?, ?, ?);
        ''', (operation, description, time.strftime("%Y-%m-%d %H:%M:%S")))
        self.conn.commit()

    def clear_memory(self):
        """Cleans up unnecessary processes to accelerate memory."""
        memory_before = psutil.virtual_memory()
        # Modify process termination logic for cross-platform compatibility
        target_processes = self.get_target_processes()
        for proc in psutil.process_iter(['pid', 'name']):
            try:
                if proc.info['name'] in target_processes:
                    proc.terminate()
                    self.log_operation("Memory Cleanup", f"{proc.info['name']} process terminated.")
            except (psutil.NoSuchProcess, psutil.AccessDenied):
                continue

        memory_after = psutil.virtual_memory()
        return memory_before, memory_after

    def get_target_processes(self):
        """Returns a list of processes to target for memory cleanup, based on the operating system."""
        if platform.system() == "Windows":
            return ["notepad.exe", "word.exe"]
        elif platform.system() == "Linux":
            return ["gedit", "libreoffice", "nano"]  # Example targets for Linux
        elif platform.system() == "Darwin":  # macOS
            return ["TextEdit", "Microsoft Word"]  # Example targets for macOS
        return []

    def monitor_temperature(self):
        """Monitors the system's temperature."""
        temperature = psutil.sensors_temperatures()
        if 'coretemp' in temperature:  # For processor temperature
            current_temp = temperature['coretemp'][0].current  # Get the first sensor
            if current_temp >= self.CRITICAL_TEMPERATURE:
                self.log_operation("Temperature Warning", f"Critical temperature: {current_temp}°C")
                return f"Critical temperature: {current_temp}°C"
        return "Temperature is normal."

    def auto_cleanup_and_monitor(self):
        """Automatic cleanup and monitoring loop"""
        while True:
            self.clear_memory()
            temp_status = self.monitor_temperature()
            time.sleep(300)  # Check every 5 minutes

class App:
    def __init__(self, root):
        self.root = root
        self.root.title("System Maintenance Application")
        self.root.geometry("600x400")

        self.start_button = tk.Button(root, text="Start Continuous Maintenance", command=self.start_background_task)
        self.start_button.pack(pady=10)

        self.result_area = scrolledtext.ScrolledText(root, width=70, height=15)
        self.result_area.pack(pady=10)

        self.maintenance = SystemMaintenance()

    def start_background_task(self):
        """Starts the maintenance task in the background."""
        threading.Thread(target=self.maintenance.auto_cleanup_and_monitor, daemon=True).start()
        self.result_area.insert(tk.END, "System maintenance has started in the background.\n")

if __name__ == "__main__":
    check_and_install_libraries()  # Check and install the required libraries
    root = tk.Tk()
    app = App(root)
    root.mainloop()
