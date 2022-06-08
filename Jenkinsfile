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

                emailext body: 'The result for the pipeline GW-1-CICD-BA-1.0-060622 build was SUCCESFULL',from: 'fjorpa93@gmail.com',subject: 'CI/CD Results', to: 'fjorpa93@gmail.com, cc:jaorpa93@gmail.com, cc:aaroncicimo3069@gmail.com, cc:lmolina@xempre.com'
            }
        }
}