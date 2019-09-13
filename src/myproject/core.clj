(ns myproject.core 
	(:gen-class) 
	(:import [java.text ParseException SimpleDateFormat]))

(defn valid-input [x] true)

(defn convert-number "Converts between numeral systems" 
	[from to number]
	(println "Convert the number " number " from " from " to " to))

(defn convert
	"Converts between numeral systems or throws exception if input is not valid"
	[arguments]
	(if (valid-input arguments)
		(let [[from to number] arguments](convert-number from to number))
		(throw (ParseException. "Wrong input" 0))))

(defn -main [ & args ]
	(convert args))
