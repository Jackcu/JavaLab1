#!/usr/bin/env bash
mvn clean cobertura:cobertura  -Dmaven.test.skip=true
