pipeline{
    agent any
    tools{
        maven 'MAVEN_3_6_3'
        jdk 'JDK_1_17'
    }

    stages {
        stage('Compile Stage') {

            steps {
                withMaven(maven : 'MAVEN_3_6_3'){
                    bat 'mvn clean compile'
                }
            }
        }
        stage ('Testing Stage'){

            steps {
                withMaven(maven : 'MAVEN_3_6_3'){
                    bat 'mvn test'
                }
            }

        }
        stage ('Deployment Stage'){

                    steps {
                        withMaven(maven : 'MAVEN_3_6_3'){
                            bat 'mvn deploy'
                        }
                    }
                }
    }
    post {
            always {
                emailext body: 'A Test EMail', recipientProviders: [[$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']], subject: 'Test'
            }
        }
}