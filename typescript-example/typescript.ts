let response: any = `{
    "data": {
        "clazzes": [
            {
                "id": "1",
                "name": "A1"
            },
            {
                "id": "2",
                "name": "A2"
            },
            {
                "id": "3",
                "name": "B1"
            },
            {
                "id": "4",
                "name": "B2"
            }
        ]
    }
}`;

interface Clazz {
  id: string;
  n: string;
}

let r = JSON.parse(response, function (key, value) {
  if (key === "name") {
    this.n = value;
    return;
  }
  return value;
});
var clazzes: Clazz[] = r.data.clazzes;
console.log(clazzes[0].n);
