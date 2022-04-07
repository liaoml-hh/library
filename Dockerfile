FROM avantport-docker.pkg.coding.net/blueteam/registry/jre:11.0.10_9
ADD @project.build.finalName@.jar app.jar
ENV NACOS_ADDR=nacos:8848 \
    NACOS_NAMESPACE=public \
    NACOS_FILE_EXT=properties