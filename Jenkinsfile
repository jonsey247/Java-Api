node {
   stage('Preparation') {
      git 'https://github.com/jonsey247/Java-Api.git'
   }
   stage('Clean') {
      sh "mvn -Dmaven.test.failure.ignore clean"
   }
   stage('Package') {
      sh "mvn -Dmaven.test.failure.ignore package"
   }
}