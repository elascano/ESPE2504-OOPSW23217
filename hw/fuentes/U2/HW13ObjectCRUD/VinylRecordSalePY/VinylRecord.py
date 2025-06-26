class VinylRecord:
    def __init__(self, title, artist, year, genre, duration, label, country, color, base_price, limited_edition):
        self.title = title
        self.artist = artist
        self.year = year
        self.genre = genre
        self.duration = duration
        self.label = label
        self.country = country
        self.color = color
        self.base_price = base_price
        self.limited_edition = limited_edition
        self.price_adjustment = self.calculate_price_adjustment()
        self.final_price = self.base_price + self.price_adjustment

    def calculate_price_adjustment(self):
        adjustment = 0.0
        if self.limited_edition:
            adjustment += self.base_price * 0.5
        if self.color.lower() != 'black':
            adjustment += 10.0
        return adjustment

    def to_dict(self):
        return {
            "title": self.title,
            "artist": self.artist,
            "year": self.year,
            "genre": self.genre,
            "duration": self.duration,
            "label": self.label,
            "country": self.country,
            "color": self.color,
            "basePrice": self.base_price,
            "limitedEdition": self.limited_edition,
            "priceAdjustment": self.price_adjustment,
            "finalPrice": self.final_price
        }
