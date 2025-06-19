class VinylRecord:
    def __init__(self, title, artist, year, gender, duration, label, country, color, price, limited_edition):
        self.title = title
        self.artist = artist
        self.year = int(year)
        self.gender = gender
        self.duration = duration
        self.label = label
        self.country = country
        self.color = color
        self.price = float(price)
        self.limited_edition = limited_edition
        
    def to_document(self):
        return {
            "title": self.title,
            "artist": self.artist,
            "year": self.year,
            "gender": self.gender,
            "duration": self.duration,
            "label": self.label,
            "country": self.country,
            "color": self.color,
            "price": self.price,
            "limitedEdition": self.limited_edition
        }