#!/bin/bash
mvn -q compile && java --enable-native-access=ALL-UNNAMED -cp target/classes:$HOME/.m2/repository/org/jline/jline/3.27.1/jline-3.27.1.jar OcarinaCLI
