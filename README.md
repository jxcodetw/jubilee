# How to run
```bash
# configs must be a git repo
$ cd configs
$ git init
$ git add .
$ git commit -m 'init'

$ docker-compose up # run all

$ docker-compose restart service # restart

$ docker-compose dowm # clean up

$ docker-compose build --no-cache [service] # build image
```

# Deploy to k8s
```bash
# see ./deployments
# see docker-compose to see if there's any file to copy
```
