#!/usr/bin/env bash

# You have to do:
# 1. Start redis: docker run -p 6379:6379 redis:7
# 2. Rum this script
# 3. curl http://localhost:8080/counter
# 4. Ctrl+C the application
# 5. look into the metadata/ folder

# See https://github.com/oracle/graalvm-reachability-metadata/blob/master/docs/CollectingMetadata.md
rm -rf metadata/
java -agentlib:native-image-agent=config-output-dir=metadata,experimental-conditional-config-part -jar build/libs/session-redis-webflux.jar

