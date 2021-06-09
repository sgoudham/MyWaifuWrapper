pipeline {
    agent {
        dockerfile {
            args '-v /root/.m2:/root/.m2'
        }
    }

    environment {
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "https"
        NEXUS_REPOSITORY = "maven-goudham"
        NEXUS_URL = credentials('fe3e0c7e-bcb1-4d55-9591-f55f71f42356')
        NEXUS_CREDENTIAL_ID = 'e5582b32-3507-4e88-ab7c-d16d701c46e9'

        CODECOV_TOKEN = credentials('44a3c021-5cbb-4a6f-bea2-ae6c51d43038')
    }

    stages {
        stage("Building") {
            steps {
                sh "mvn -B -DskipTests clean install"
            }
        }
        stage("Testing") {
            steps {
                sh "mvn test"
            }
        }
        stage("Deploying To Nexus") {
            when {
                branch 'release'
            }
            steps {
                script {
                    pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");

                    javadocsArtifact = filesByGlob[0].path;
                    jarWithSourcesArtifact = filesByGlob[1].path;
                    jarArtifact = filesByGlob[2].path;

                    if (fileExists(javadocsArtifact) && fileExists(jarWithSourcesArtifact) && fileExists(jarArtifact)) {
                        echo "*** File: ${javadocsArtifact}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        echo "*** File: ${jarWithSourcesArtifact}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        echo "*** File: ${jarArtifact}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";

                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                               [artifactId: pom.artifactId, classifier: '', file: jarArtifact, type: pom.packaging],
                               [artifactId: pom.artifactId, classifier: 'javadocs', file: javadocsArtifact, type: pom.packaging],
                               [artifactId: pom.artifactId, classifier: 'sources', file: jarWithSourcesArtifact, type: pom.packaging],
                               [artifactId: pom.artifactId, classifier: '', file: "pom.xml", type: "pom"]
                            ]
                        )
                    } else {
                        error "*** Files could not be found";
                    }
                }
            }
        }
    }

    post {
        success {
            echo "I'm Feeling Swag!"

            echo "Archiving Artifacts"
            archiveArtifacts artifacts: 'target/*.jar'

            echo "Generating Test Report..."
            publishCoverage adapters: [jacocoAdapter('target/site/jacoco/jacoco.xml')]

            echo "Sending Report to CodeCov..."
            sh '''#!/bin/bash
                  bash <(curl -s https://codecov.io/bash) -t $CODECOV_TOKEN || echo "Codecov did not collect coverage reports"
               '''
        }
        failure {
            echo 'Not Very Swag :('
        }
        cleanup {
            cleanWs()
        }
    }
}