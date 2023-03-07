import fetch from "unfetch";

export const fetchFlights = () =>
    fetch('/api/v1/flights')
        .then(r => r.json())
