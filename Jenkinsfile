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

   stage('Docker Build') {
       sh "docker build -t mytvapp ."
   }

   stage('Docker Deploy') {
       sh "docker run -d -p 8081:8080 mytvapp"
   }
}