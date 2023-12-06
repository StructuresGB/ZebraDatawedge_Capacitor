export interface ZebraDataWedgePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
