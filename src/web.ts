import { WebPlugin } from '@capacitor/core';

import type { ZebraDataWedgePlugin } from './definitions';

export class ZebraDataWedgeWeb
  extends WebPlugin
  implements ZebraDataWedgePlugin
{
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
