groupId="com.gulci"

if [ "$2" != "" ] ; then
    groupId=$2
fi

if [ "$1" != "" ] ; then
    mvn archetype:generate -DarchetypeGroupId=de.rieckpil.archetypes \
    -DarchetypeArtifactId=javaee8-jsf \
    -DarchetypeVersion=1.0.1 \
    -DgroupId=$groupId \
    -DartifactId=$1 \
    -DinteractiveMode=false
else
    echo "Specify artifactId"
fi
