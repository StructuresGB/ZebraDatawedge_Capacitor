import {Plugin} from "@capacitor/core/types/definitions";

export interface ZebraDataWedgePlugin extends Plugin {

}

export interface ZebraDataWedgeScanResult {
  source: string;
  data: string;
  labelType: string
}