(defproject test1 "0.1.0-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :min-lein-version "2.0.0"
            :dependencies [[org.clojure/clojure "1.8.0"]
                           [compojure "1.5.1"]
                           [ring/ring-jetty-adapter "1.5.0"]
                           [ring/ring-defaults "0.2.1"]
                           [ring/ring-jetty-adapter "1.5.0"]]
            :plugins [[lein-ring "0.10.0"]]
            :ring {:handler test1.handler/app
                   :uberwar-name "test1.war"
                   :servlet-name "test1Servlet"}
            :main test1.handler
            :aot :all
            :profiles
            {:uberjar {:aot :all}
             :dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring/ring-mock "0.3.0"]]}})
