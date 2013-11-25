(ns tweetstorm.views.tweets
  (:use [compojure.core :only (defroutes GET)]
        [hiccup.core :only (html)]))

(defn index []
  (html [:h "OH HELLO HOW ARE YOU"]))

(defroutes routes
  (GET "/" [] (index)))
