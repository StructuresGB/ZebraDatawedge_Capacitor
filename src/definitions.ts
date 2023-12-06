import type { Plugin } from '@capacitor/core/types/definitions';

// eslint-disable-next-line @typescript-eslint/no-empty-interface
export interface ZebraDataWedgePlugin extends Plugin {}

export interface ZebraDataWedgeScanResult {
  source: string;
  data: string;
  labelType: string;
}
