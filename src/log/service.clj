(ns log.service
  (:require [common.consumer :as consumer]
            [log.controller :as controller]))

(defn start []
  (println "Starting Log Service")
  (consumer/create "BANK" controller/logging))