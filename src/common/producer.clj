(ns common.producer
  (:require
    [jackdaw.client :as jc]
    [clojure.data.json :as json])
  (:import [java.util UUID]))

(def producer-config
  {"bootstrap.servers" "localhost:9092"
   "key.serializer" "org.apache.kafka.common.serialization.StringSerializer"
   "value.serializer" "org.apache.kafka.common.serialization.StringSerializer"
   "acks" "all"
   "client.id" "foo"})


(defn create-topic
  [name]
  {:topic-name name})

(defn produce!
  [topic key value]
  (println "producing" topic key)
  (with-open [producer (jc/producer producer-config)]
    @(jc/produce! producer topic (str key "-" (UUID/randomUUID)) (json/write-str value))))