FROM openjdk:7-jdk

USER root

RUN apt-get update && apt-get install -y
 
RUN apt-get -y install zip

RUN curl -s "https://get.sdkman.io" | bash

RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh"

RUN /bin/bash -c "source $HOME/.bashrc"

RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && echo -n | sdk install gradle 2.3"

RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && echo -n | sdk install grails 3.0.1"

RUN /bin/bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && echo -n | sdk install java 8u131-zulu"

RUN curl -fsSL https://get.docker.com/ | sh

#RUN curl -L https://github.com/docker/compose/releases/download/1.8.0/docker-compose-`uname -s`-`uname -m` > /usr/local/bin/docker-compose

#RUN chmod +x /usr/local/bin/docker-compose

RUN apt-get -y install sudo

RUN /bin/bash -c "service docker start"

#RUN gpasswd -a root docker
RUN usermod -aG docker root

RUN /bin/bash -c "source $HOME/.bashrc"

RUN service docker restart

