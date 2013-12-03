(ns stream
  (:use
   [twitter.api.streaming]
   [twitter.oauth]
   [twitter.callbacks]
   [twitter.callbacks.handlers]
   [twitter.api.restful]
   )
  (:require
   [clojure.data.json :as json]
   [http.async.client :as ac]
   [twitter.callbacks.protocols])
  (:import
   [twitter.callbacks.protocols AsyncStreamingCallback]
                                        ;[twitter4j.conf ConfigurationBuilder]
                                        ;[twitter4j TwitterFactory]
   )
  )

(def make-creds (make-oauth-creds
                 (System/getenv "TWITTER_ACCESS_TOKEN")
                 (System/getenv "TWITTER_ACCESS_SECRET")
                 (System/getenv "TWITTER_CONSUMER_KEY")
                 (System/getenv "TWITTER_CONSUMER_SECRET")
                 ))

; retrieves the user stream, waits 1 minute and then cancels the async call
(def ^:dynamic *response* (user-stream :oauth-creds make-creds))
(Thread/sleep 60000)
((:cancel (meta *response*)))

(def ^:dynamic
     *custom-streaming-callback*
     (AsyncStreamingCallback. (comp println #(:text %) json/read-json #(str %2))
                      (comp println response-return-everything)
                  exception-print))
