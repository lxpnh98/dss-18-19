USER=root
PASS=password
CJ=

build:
	javac Main.java

# utilizar credenciais do MySQL
# como utilizar (exemplo): make run USER=user PASS=hunter2
run:
	java -cp .:/usr/share/java/mysql-connector-java.jar Main -- '$(USER)' '$(PASS)' '$(CJ)'

clean:
	rm *.class */*.class
