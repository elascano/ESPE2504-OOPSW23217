export const Direction = {
  NORTH: { rowOffset: -1, colOffset: 0, name: 'NORTH' },
  SOUTH: { rowOffset: 1, colOffset: 0, name: 'SOUTH' },
  EAST:  { rowOffset: 0, colOffset: 1, name: 'EAST' },
  WEST:  { rowOffset: 0, colOffset: -1, name: 'WEST' },

  all() {
    return [this.NORTH, this.SOUTH, this.EAST, this.WEST];
  },

  opposite(dir) {
    switch (dir) {
      case this.NORTH: return this.SOUTH;
      case this.SOUTH: return this.NORTH;
      case this.EAST: return this.WEST;
      case this.WEST: return this.EAST;
    }
  }
};
