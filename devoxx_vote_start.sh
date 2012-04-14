#!/bin/bash

DIR_APPLICATIONS="$HOME/applications"
LILY_VERSION="1.1.2"
LILY_DIR_NAME="lily-$LILY_VERSION"
LILY_HOME="$DIR_APPLICATIONS/$LILY_DIR_NAME"
LILY_BIN="$LILY_HOME/bin"
RESOURCES="lily-devoxx/src/main/resources"

SOLR_SCHEMA_FILE="$RESOURCES/devoxx_vote_solr_schema.xml"
LILY_SCHEMA_FILE="$RESOURCES/devoxx_vote.json"
INDEXER_CONF_FILE="$RESOURCES/devoxx_vote_indexerconf.xml"

SOLR_URL="http://localhost:8983/solr"

$LILY_BIN/launch-test-lily -c 1 -s $SOLR_SCHEMA_FILE &

sleep 60

$LILY_BIN/lily-import $LILY_SCHEMA_FILE

sleep 20

$LILY_BIN/lily-add-index -n devoxx_index -c $INDEXER_CONF_FILE -s shard1:$SOLR_URL

#$LILY_BIN/lily-update-index -n devoxx_index --build-state BUILD_REQUESTED


