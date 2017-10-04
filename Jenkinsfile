try {
    node {
        stage('Build') {
            echo 'Building....'
            deleteDir()
            checkout scm

            sh 'chmod 755 ./gradlew'
            sh './gradlew clean build'
            step([$class: 'JUnitResultArchiver', testResults: '**/test-results/TEST-*.xml'])
        }
        stage('Test') {
            echo 'Running Tests....'
            sh './gradlew bootRun'
            sh './gradlew cucumberTests'

            step([$class: 'JUnitResultArchiver', testResults: '**/cucumber-test-results/TEST-*.xml'])
            step([$class: 'JacocoPublisher', execPattern:'build/jacoco/test.exec', classPattern: 'build/classes/main',
                 sourcePattern: 'src/main/java'])
        }
        stage('Deploy') {
            if (currentBuild.result == 'UNSTABLE' || currentBuild.result == 'FAILURE') {
                echo 'Not Deploying build result was: ' + currentBuild.result
            } else {
                echo 'Deploying....'
            }
        }
    }
} catch (ex) {
    echo "Caught exception: ${ex}"

    String toList = 'buildWatchers@myCompany.com'

    mail subject: "${env.JOB_NAME} (${env.BUILD_NUMBER}) failed",
            body: "Build: ${env.BUILD_URL} is failing",
              to: toList,
         replyTo: toList,
            from: 'noreply@myCompany.com'

    throw exc
}