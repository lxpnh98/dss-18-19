USER=root
PASS=password
CJ=n # deixar vazio se url de ligação do MySQL for "com.mysql.cj.jdbc.Driver"

build: clean
	javac Main.java

# utilizar credenciais do MySQL
# como utilizar (exemplo): make run USER=user PASS=hunter2
run:
	java -cp .:/usr/share/java/mysql-connector-java.jar Main $(USER) $(PASS) $(CJ)

clean:
	rm -f *.class */*.class
