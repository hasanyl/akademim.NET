import {
    Card,
    CardAction,
    CardContent,
    CardDescription,
    CardHeader,
    CardTitle
} from "@/components/ui/card.jsx";
import {Badge} from "@/components/ui/badge.jsx";
import { Clock, Code, Paintbrush} from "lucide-react";

export default function LandingPage(){
    return(
        <>
            <div className={"min-h-screen flex items-center w-full justify-center p-4"}
                 style={{
                     backgroundImage: `linear-gradient(rgba(0,0,0,0.65), rgba(0,0,0,0.65)), url('https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe?auto=format&fit=crop&w=2400&q=80')`
                 }}
            >
                <div className="w-full max-w-6xl flex flex-col gap-6">
                    <div className="w-full select-none">
                        <svg viewBox="0 0 1000 110" className="w-full h-auto overflow-visible">
                            <defs>
                                <linearGradient id="appleTitleGrad" x1="0" y1="0" x2="0" y2="1">
                                    <stop offset="0%" stopColor="#ffffff" />
                                    <stop offset="55%" stopColor="#ffffff" stopOpacity="0.9" />
                                    <stop offset="100%" stopColor="#ffffff" stopOpacity="0.25" />
                                </linearGradient>
                            </defs>
                            <text
                                x="0"
                                y="95"
                                textLength="1000"
                                lengthAdjust="spacing"
                                fill="url(#appleTitleGrad)"
                                style={{
                                    fontFamily: "system-ui, -apple-system, sans-serif",
                                    fontWeight: 900,
                                    fontSize: "115px",
                                    letterSpacing: "normal"
                                }}
                            >
                                AKADEMİM.NET
                            </text>
                        </svg>
                    </div>
                    <div className={"grid grid-cols-1 md:grid-cols-3 gap-6 items-stretch w-full max-w-6xl"}>
                        <Card className={"md:col-span-2 h-full flex flex-col justify-between bg-white/5 backdrop-blur-md border border-white/10 shadow-[inset_0_1px_0_0_rgba(255,255,255,0.1)]"}>
                            <CardHeader>
                                <CardTitle>Akademim.NET</CardTitle>
                                <CardDescription>Üniversite öğrencileri için geliştirilmiş özel bir sistem</CardDescription>
                                <CardAction>
                                    <Badge
                                        variant="outline" className="flex items-center gap-1.5 bg-white/10 text-stone-200 border-white/15 backdrop-blur-md shadow-[inset_0_1px_0_0_rgba(255,255,255,0.15)]"
                                    >
                                        <Clock data-icon={"inline-start"}/>
                                        Yakında
                                    </Badge>
                                </CardAction>
                            </CardHeader>
                            <CardContent className={"flex-1 flex flex-col justify-between pt-2"}>
                                <div className="space-y-4 text-stone-200 text-sm leading-relaxed">
                                    <p>
                                        Akademim.NET sizin için ders planınızı kontrol eden, devamsızlık takibi yapan ve bunları sistematik bir şekilde yapan bir programdır.
                                        Bu programın temel amacı, dağınık olan akademik bilgileri tek bir program çatısı altında toplamak ve sizlere daha kolay ulaşılabilir bilgiler sunmaktır.
                                    </p>
                                </div>

                                <div>
                                    <p className="text-stone-300/80">
                                    Özellikle karmaşık ders programları, takip edilemeyen devamsızlıklar ve bir sınava kaç gün kaldı gibi sorunları çözmek üzerine derin
                                    çalışmalar yürüttüğümüz bu programda sizler için pek çok özellik ekliyoruz.
                                </p></div>

                                <div className="flex flex-wrap gap-2 my-4">
                                    <span className="text-xs px-2.5 py-1 rounded-md bg-white/5 border border-white/10 text-stone-300">Ders Takibi</span>
                                    <span className="text-xs px-2.5 py-1 rounded-md bg-white/5 border border-white/10 text-stone-300">Devamsızlık Takibi</span>
                                    <span className="text-xs px-2.5 py-1 rounded-md bg-white/5 border border-white/10 text-stone-300">Not Defteri</span>
                                    <span className="text-xs px-2.5 py-1 rounded-md bg-white/5 border border-white/10 text-stone-300">Hatırlatıcı</span>
                                </div>
                            </CardContent>
                        </Card>


                        <div className={"flex flex-col gap-6 h-full"}>
                            <Card className={"h-auto  p-6 bg-white/5 backdrop-blur-md border border-white/10 shadow-[inset_0_1px_0_0_rgba(255,255,255,0.1)]"}>
                                <CardHeader>
                                    <CardTitle>Neden Akademim.NET</CardTitle>
                                    <CardDescription>Tamamen Özelleştirilebilir</CardDescription>
                                    <CardAction>
                                        <Badge variant={"secondary"}
                                               className="flex items-center gap-1.5 bg-white/10 hover:bg-white/15 text-stone-200 border border-white/15 backdrop-blur-md shadow-[inset_0_1px_0_0_rgba(255,255,255,0.15)]"
                                        >
                                            <Paintbrush data-icon={"inline-start"}/>
                                            Özelleştir
                                        </Badge></CardAction>
                                </CardHeader>
                                <CardContent className={"flex-1"}>
                                    <p>Akademim.NET sizin ihtiyaçlarınıza ve zevklerinize göre tamamen şekillendirilebilir şekilde tasarlandı.</p>
                                </CardContent>
                            </Card>

                            <Card className={"h-auto p-6 bg-white/5 backdrop-blur-md border border-white/10 shadow-[inset_0_1px_0_0_rgba(255,255,255,0.1)]"}>
                                <CardHeader>
                                    <CardTitle>Akademim.NET</CardTitle>
                                    <CardDescription>Güncel teknolojilerle</CardDescription>
                                    <CardAction>
                                        <Badge variant={"secondary"}
                                               className="flex items-center gap-1.5 bg-white/10 hover:bg-white/15 text-stone-200 border border-white/15 backdrop-blur-md shadow-[inset_0_1px_0_0_rgba(255,255,255,0.15)]"
                                        >
                                            <Code data-icon={"inline-start"} />
                                            Geliştiriliyor
                                        </Badge>
                                    </CardAction>
                                </CardHeader>
                                <CardContent className={"flex-1"}>
                                    <p>Uygulamamız henüz geliştirme aşamasındadır. Gelişmeleri github hesabımızdan takip edebilirsiniz!</p>
                                </CardContent>
                            </Card>
                </div>


                        </div>
                    </div>

            </div>




        </>
    );
}