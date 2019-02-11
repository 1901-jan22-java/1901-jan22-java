const fire = {
    attributes: {
        _heat : 0.5,
        _color : 'red',
        _size : 100,
    },

    get heat() {
        if(this._heat > 0) {
            return this._heat;
        }
    },

    get color() {
        if(this._color) {
            return this._color;
        }
    },

    get size() {
        if(this._size > 0) {
            return this._size;
        }
    },

    playWithFire() {
        console.log(`A fire is burning ${this.color} with the intensity of ${this.heat * 100}% of catastrophy! It has covered ${this.size} meters! AHHHHHH!`);
    },
};

fire.playWithFire();
