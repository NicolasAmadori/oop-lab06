# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
*Non copiato*

2. Ci si assicuri di avere localmente entrambi i branch remoti

git branch -vv
* feature bed943f [origin/feature] Print author information
  master  4cb0f4a [origin/master: ahead 1] File di salvataggio degli output dei comandi

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`

git checkout master
Switched to branch 'master'
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

$ git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.

4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote

$ git remote add personale  git@github.com:NicolasAmadori/PrimoEsercizioGitHub.git

$ git remote -v
origin  git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (fetch)
origin  git@github.com:APICe-at-DISI/OOP-git-merge-conflict-test.git (push)
personale       git@github.com:NicolasAmadori/PrimoEsercizioGitHub.git (fetch)
personale       git@github.com:NicolasAmadori/PrimoEsercizioGitHub.git (push)

8. Si faccia push del branch `master` sul proprio repository

$ git push -u personale master
Enter passphrase for key '/c/Users/nicolas.amadori/.ssh/id_rsa': 
Enumerating objects: 18, done.
Counting objects: 100% (18/18), done.
Delta compression using up to 12 threads
Compressing objects: 100% (13/13), done.
Writing objects: 100% (18/18), 1.81 KiB | 464.00 KiB/s, done.
Total 18 (delta 6), reused 9 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (6/6), done.
To github.com:NicolasAmadori/PrimoEsercizioGitHub.git
 * [new branch]      master -> master
branch 'master' set up to track 'personale/master'.

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale

*passaggio precedente*