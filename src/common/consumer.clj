(ns common.consumer
  (:require
    [jackdaw.client :as jc]
    [jackdaw.client.log :as jl]
    [clojure.data.json :as json])
  (:import
    (org.apache.kafka.common.serialization Serdes)))

(def consumer-config
  {"bootstrap.servers" "localhost:9092"
   "key.deserializer" "org.apache.kafka.common.serialization.StringDeserializer"
   "value.deserializer" "org.apache.kafka.common.serialization.StringDeserializer"
   "group.id"  "com.foo.my-consumer"})

(defn create [name callback]
  (let [topic {:topic-name name}
        consumer (fn [] (with-open [my-consumer (-> (jc/consumer consumer-config)
                                                 (jc/subscribe [topic]))]
                       (doseq [{:keys [key value partition timestamp offset]} (jl/log my-consumer 500)]
                         (callback key (json/read-str value
                                                      :key-fn keyword)))))]
    (doto
      (Thread. consumer)
      (.setDaemon true)
      (.start))))