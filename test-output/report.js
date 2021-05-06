$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("enviarDineroAlias.feature");
formatter.feature({
  "line": 1,
  "name": "Consultar Alias",
  "description": "",
  "id": "consultar-alias",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "Llamada al metodo POST que consultar los datos del cliente",
  "description": "",
  "id": "consultar-alias;llamada-al-metodo-post-que-consultar-los-datos-del-cliente",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@Post"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "envio el json con los datos del cliente",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "verifica que trae al cliente correcto",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitionsBack.envio_el_json_con_los_datos_del_cliente()"
});
formatter.result({
  "duration": 3997622800,
  "status": "passed"
});
formatter.match({
  "location": "stepDefinitionsBack.verifica_que_trae_al_cliente_correcto()"
});
formatter.result({
  "duration": 18100,
  "status": "passed"
});
});