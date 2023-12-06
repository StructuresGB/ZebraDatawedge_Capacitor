import { registerPlugin } from '@capacitor/core';

import type { ZebraDataWedgePlugin } from './definitions';

const ZebraDataWedge = registerPlugin<ZebraDataWedgePlugin>('ZebraDataWedge', {
  web: () => import('./web').then(m => new m.ZebraDataWedgeWeb()),
});

export * from './definitions';
export { ZebraDataWedge };
