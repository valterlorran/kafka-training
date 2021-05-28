(ns alura-kafka.test
  (:require [common.producer :as producer])
  (:import [java.util UUID]))

(def merchants ["Lojinha A", "Lojinha B", "Supermercado A", "Apple Store"])

(defn make-credit-card []
  {:id (UUID/randomUUID)})

(defn create-random-purchase []
  {:id     (UUID/randomUUID)
   :amount (+ 10000 (rand-int 300000))
   :merchant (get merchants (rand-int (count merchants)))
   :credit-card (make-credit-card)})


(defn create-new-purchase
  []
  (let [topic (producer/create-topic "BANK_PURCHASE_CREATED")
        purchase (create-random-purchase)]
    (producer/produce! topic "purchase" purchase)))

(defn run-tests []
  (println "Running Tests")
  (create-new-purchase))