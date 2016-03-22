#!/bin/sh
git pull origin master
now="$(date): update all by Alan Sii Hee Kwong"

git add -A README.md
git add -A Alan/*
git add -A update-Alan.sh

git commit -m "$now"
git push origin master