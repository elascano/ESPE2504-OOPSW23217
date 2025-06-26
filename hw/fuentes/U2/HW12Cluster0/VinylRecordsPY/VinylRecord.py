class VinylRecord:
    def __init__(self, title, artist, year, gender, duration, label,
                 country, color, track_count, limited_edition):
        self.title = title
        self.artist = artist
        self.year = year
        self.gender = gender
        self.duration = duration
        self.label = label
        self.country = country
        self.color = color
        self.track_count = track_count
        self.limited_edition = limited_edition

    def to_dict(self):
        return {
            "title": self.title,
            "artist": self.artist,
            "year": self.year,
            "gender": self.gender,
            "duration": self.duration,
            "label": self.label,
            "country": self.country,
            "color": self.color,
            "track_count": self.track_count,
            "limited_edition": self.limited_edition
        }
