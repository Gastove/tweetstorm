(ns tweetstorm.core
  (:use [compojure.core :only (defroutes GET)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [tweetstorm.views.tweets :as tweets]
            [tweetstorm.views.layouts :as layouts]))

(defroutes app-routes
  ;(GET "/" [] "Hello World")
  tweets/routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
