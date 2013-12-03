(ns tweetstorm.core
  (:use [compojure.core :only (defroutes GET)])
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [tweetstorm.views.tweets :as tweets]
            [tweetstorm.views.layouts :as layouts]
            [tweetstorm.data.twitter.stream :as tweetstream]))

(defroutes app-routes
  tweets/routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
