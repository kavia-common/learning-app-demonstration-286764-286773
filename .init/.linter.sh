#!/bin/bash
cd /home/kavia/workspace/code-generation/learning-app-demonstration-286764-286773/springboot_backend
./gradlew checkstyleMain
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

