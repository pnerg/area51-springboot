docker run --rm  \
   --name keycloak \
   -v $PWD:/tmp \
   -e KEYCLOAK_USER=admin \
   -e KEYCLOAK_PASSWORD=admin \
   -e KEYCLOAK_IMPORT=/tmp/keycloak-realm.json \
   -p 8180:8180 \
   -p 9990:9990 \
   quay.io/keycloak/keycloak:12.0.4 \
   -Djboss.http.port=8180 \
   -Dkeycloak.profile.feature.upload_scripts=enabled \
   -Dkeycloak.migration.action=import \
   -Dkeycloak.migration.provider=singleFile \
   -Dkeycloak.migration.realmName=area51 \
   -Dkeycloak.migration.file=/tmp/keycloak-realm.json
