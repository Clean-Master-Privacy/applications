import git

def commit_changes():
    # Depoyu klonla veya mevcut olanı aç
    repo = git.Repo(search_parent_directories=True)
    # Değişiklikleri ekle ve commit et
    repo.git.add(A=True)
    repo.index.commit("AI model corrected the code")
    # Değişiklikleri GitHub'a push et
    origin = repo.remote(name='origin')
    origin.push()

if __name__ == "__main__":
    commit_changes()
