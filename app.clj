(ns app
  (:require [db])
  (:gen-class)) 

(defn do-something 
  "TODO"
  [x y]
  (println "This should probably do something with" x "and" y)) 

(defn -main 
  "TODO"
  [& _args]
  (do-something 10 20)
  (db/db))