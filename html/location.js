var geo = document.getElementById('geo'); // id로 geo 값을 가지는 태크(span, div) 만들고 사용해야 작동합니다.

class Location {
    static #location = 'location';

    _constructor() {
    }

    static getAddress() {
        navigator.geolocation.getCurrentPosition(this.getAddress1, (error) => { console.error(error.message); });
    }

    static reverseGeocoding (position) {
        const url = `https://geocode.maps.co/reverse?lat=${position.coords.latitude}&lon=${position.coords.longitude}`;

        fetch(url)
            .then((res) => res.json())
            .then((json) => geo.innerText = json.address.city)
            .catch((error) => console.error(error));
    }
}

// refernce - https://w3c.github.io/geolocation-api/#get-current-position, https://geocode.maps.co