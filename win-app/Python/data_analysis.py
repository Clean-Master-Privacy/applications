import pandas as pd

def analyze_data(data):
    df = pd.DataFrame(data)
    return df.describe()
