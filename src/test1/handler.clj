(ns test1.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.adapter.jetty :as jetty]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]))

(defn index
  [req]
  {:status 200
   :headers {"Content-Type" "text/html"}
   :body "Hello world"})

(defroutes app-routes
           (GET "/" [] index)
           (GET "/hello" [] index)
           (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))

(defn start-server
  []
  (jetty/run-jetty app))

(defn -main [& args]
  (start-server))
