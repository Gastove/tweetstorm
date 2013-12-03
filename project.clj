(defproject tweetstorm "0.1.0-SNAPSHOT"
  :description "Stream processing with Clojure"
  :repositories {
                 "twitter4j" "http://twitter4j.org/maven2"
                 }
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [hiccup "1.0.4"]
                 [compojure "1.1.6"]
                 ;[storm "0.9.0-rc2"]
                 [twitter-api "0.7.4"]
                 ;[org.twitter4j/twitter4j-core "3.0.5"]
                 ;[org.twitter4j/twitter4j-stream "3.0.5"]
                 ]
  :plugins [[lein-ring "0.8.8"]]
  ;:jvm-opts ["-Djava.library.path=/usr/local/lib:/opt/local/lib:/usr/lib:/Users/gastove/.m2"]
  :ring {:handler tweetstorm.core/app}
  :profiles {:dev
             {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
