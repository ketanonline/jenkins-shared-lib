def call(Map pipelineParams) {

    // evaluate the body block, and collect configuration into the object

    pipeline {
        agent any
        stages {
            stage('checkout git') {
                steps {
                    sh 'echo "Now checkiing out"'
                    git branch: pipelineParams.branch, credentialsId: '	ketangitjenkins', url: pipelineParams.scmUrl
                }
            }

            // stage('build') {
            //     steps {
            //         sh 'mvn clean package -DskipTests=true'
            //     }
            // }

            // stage ('test') {
            //     steps {
            //         parallel (
            //             "unit tests": { sh 'mvn test' },
            //             "integration tests": { sh 'mvn integration-test' }
            //         )
            //     }
            // }

            // stage('deploy developmentServer'){
            //     steps {
            //         deploy(pipelineParams.developmentServer, pipelineParams.serverPort)
            //     }
            // }

            // stage('deploy staging'){
            //     steps {
            //         deploy(pipelineParams.stagingServer, pipelineParams.serverPort)
            //     }
            // }

            // stage('deploy production'){
            //     steps {
            //         deploy(pipelineParams.productionServer, pipelineParams.serverPort)
            //     }
            // }
        }
    }
}
