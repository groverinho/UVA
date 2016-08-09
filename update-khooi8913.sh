#!/bin/sh
git pull origin master
now="$(date): update all by khooi8913"

git add -A README.md
git add -A khooi8913/*
git add -A update-khooi8913.sh

git commit -m "$now"
git push origin master