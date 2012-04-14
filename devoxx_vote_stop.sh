#!/bin/bash

# Kill all the lily process
jps | grep ClassLoadingLilyLauncher | awk '{print $1}' | xargs kill -9 > /dev/null &



