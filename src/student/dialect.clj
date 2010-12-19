(ns 
  student.dialect
  (:require [clojure.contrib.str-utils2 :as s]))

(defn canadianize [sentence] (str (s/chop sentence) ", eh"))

;(defn pig-latinize [sentence] 